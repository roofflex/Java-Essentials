package workwithfiles.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferExample2 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("test5.txt", "r");
            FileChannel channel = file.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip();

            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());

            // now the buffer's position is 3
            // .rewind() sets the position to 0
            // so we can read first items  again
            buffer.rewind();
            System.out.println((char)buffer.get());

            System.out.println("------------------\n");

            // if we have some unread items in buffer and we want to leave it
            // for further use, we can invoke .compact() on buffer,
            // instead of .clear()
            // .compact() will copy left items
            // in the beginning of the buffer, then
            // set buffer in writing mode
            buffer.compact();
            channel.read(buffer);
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println((char)buffer.get());
            }

            buffer.clear();
            channel.read(buffer);
            buffer.flip();

            System.out.println("------------------\n");

            System.out.println((char)buffer.get());

            // .mark() marks the position in buffer, that we may want to return to
            buffer.mark();
            System.out.println("Made a mark here.");
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());

            // .reset() resets position to the marked position
            buffer.reset();
            System.out.println("Return to the marked position");
            System.out.println((char)buffer.get());






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
