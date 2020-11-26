package workwithfiles.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferExample {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("test10.txt", "rw");
            FileChannel channel = file.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(20);
            StringBuilder poem = new StringBuilder();

            int byteRead = channel.read(buffer);
            while(byteRead > 0){
                System.out.println("Read: " + byteRead);

                // .flip() sets the position in buffer to 0 and changes
                // buffer's mode from write to read
                // now we can read all the bytes in buffer from the start
                buffer.flip();
                while (buffer.hasRemaining()){
                    poem.append((char) buffer.get());
                }

                // .clear() sets the position in buffer to 0 and changes
                // buffer's mode from read to write,
                // so now we can rewrite the buffer with new data
                buffer.clear();
                byteRead = channel.read(buffer);

            }
            System.out.println(poem);

            String quote = "\nThere are only two ways to live your life. One is as though nothing is a miracle."
                                + "The other is as though everything is a miracle.";

            // Option 1 to write in file using Buffer and Channel:
//            ByteBuffer writeBuffer = ByteBuffer.allocate(quote.getBytes().length);
//
//            writeBuffer.put(quote.getBytes());
//            writeBuffer.flip();
//            channel.write(writeBuffer);

            // Option 2 to write in file
            ByteBuffer buffer2 = ByteBuffer.wrap(quote.getBytes());
            channel.write(buffer2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
