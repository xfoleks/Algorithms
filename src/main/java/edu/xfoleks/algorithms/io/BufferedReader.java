package edu.xfoleks.algorithms.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class is used for performing the actions of the original buffered reader
 * It implements different actions, such as peek(n) to lookahead,
 * block() to read a chunk of size {BUFFER SIZE}
 */

public class BufferedReader {

    private static final int DEFAULT_BUFFER_SIZE = 5;

    private int bufferSize;
    private final byte[] buffer;

    private int positionRead = 0, bufferPosition = 0;

    private boolean isEndOfFile = false;

    private InputStream inputStream;

    public BufferedReader(byte[] inputData) throws IOException {
        this(new ByteArrayInputStream(inputData));
    }

    public BufferedReader(InputStream inputStream) throws IOException {
        this(inputStream, DEFAULT_BUFFER_SIZE);
    }

    public BufferedReader(InputStream inputStream, int bufferSize) throws IOException {
        this.inputStream = inputStream;
        if (inputStream.available() == -1) throw new IOException("Empty or already closed stream provided");

        this.bufferSize = bufferSize;
        buffer = new byte[bufferSize];
    }

    public int read() throws IOException {
        if (needsRefill()) {
            if (isEndOfFile) return -1;
            refill();
        }
        return buffer[positionRead++] & 0xFF;
    }

    public int getNumberOfAvailableBytes() throws IOException {
        int available = inputStream.available();
        if (needsRefill())
            return available;
        return bufferPosition - positionRead + available;
    }

    public int peek(int indexOfValue) throws IOException {
        int available = getNumberOfAvailableBytes();
        if (indexOfValue >= available)
            throw new IOException("Out of range, available %d, but trying with %d".formatted(available, indexOfValue));
        pushRefreshData();

        if (indexOfValue >= bufferSize)
            throw new IllegalAccessError("Can't peek %s, maximum upto %s (Buffer Limit)".formatted(indexOfValue, bufferSize));
        return buffer[indexOfValue];
    }

    public byte[] readBlock() throws IOException {
        pushRefreshData();

        byte[] cloned = new byte[bufferSize];

        if (bufferPosition >= 0)
            System.arraycopy(buffer, 0, cloned, 0, bufferSize);
        refill();
        return cloned;
    }

    public void close() throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                inputStream = null;
            }
        }
    }

    private boolean needsRefill() {
        return bufferSize == 0 || positionRead == bufferPosition;
    }

    private void refill() throws IOException {
        positionRead = 0;
        bufferPosition = 0;
        justRefill();
    }

    private void justRefill() throws IOException {
        assertStreamOpen();

        while (bufferPosition < bufferSize) {
            int readBytes = inputStream.read();
            if (readBytes == -1) {
                isEndOfFile = true;
                bufferSize = bufferPosition;
            }
            buffer[bufferPosition++] = (byte) readBytes;
        }
    }

    private void assertStreamOpen() {
        if (inputStream == null)
            throw new IllegalStateException("Input Stream already closed");
    }

    /**
     * Remove the already read bytes from the buffer in-order to make space
     * for new bytes to be filled up.
     * This may also do the job to read first time data (the whole buffer is empty)
     */

    private void pushRefreshData() throws IOException {
        for (int i = positionRead, j = 0; i < bufferSize; i++, j++)
            buffer[j] = buffer[i];

        bufferPosition -= positionRead;
        positionRead = 0;

        // fill out the spaces that we've emptied
        justRefill();
    }
}
