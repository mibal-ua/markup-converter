/*
 * Copyright (c) 2024. mailto:9mohapx9@gmail.com
 *
 * The Hotel booking service Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package ua.mibal.adapter.out;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import ua.mibal.adapter.out.component.FileWriterFactory;
import ua.mibal.test.annotation.UnitTest;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class FileWriterContentSender_UnitTest {

    private FileWriterContentSender sender;

    @Mock
    private FileWriter fileWriter;
    private MockedStatic<FileWriterFactory> fileWriterFactory;

    @BeforeEach
    void setUp() {
        fileWriterFactory = mockStatic(FileWriterFactory.class);
        sender = new FileWriterContentSender("path/to/out/file");
    }

    @AfterEach
    void close() {
        fileWriterFactory.close();
    }

    @Test
    void send() throws IOException {
        fileWriterFactory.when(() -> FileWriterFactory.getFor("path/to/out/file"))
                .thenReturn(fileWriter);

        sender.send("CONTENT TO WRITE");

        verify(fileWriter).write("CONTENT TO WRITE");
    }

    @Test
    void send_should_throw_FileWriterContentSenderException() {
        fileWriterFactory.when(() -> FileWriterFactory.getFor("path/to/out/file"))
                .thenThrow(IOException.class);

        assertThrows(FileWriterContentSenderException.class,
                () -> sender.send("CONTENT TO WRITE"));
    }
}
