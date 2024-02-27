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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ua.mibal.adapter.out.component.FileWriterFactory;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.test.annotation.UnitTest;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class FileWriterContentSender_UnitTest {
    private static final String OUTPUT_PATH_KEY = "output-path";

    private FileWriterContentSender sender;

    @Mock
    private FileWriterFactory fileWriterFactory;

    @Mock
    private Arguments args;
    @Mock
    private FileWriter fileWriter;

    @BeforeEach
    void setUp() {
        sender = new FileWriterContentSender(fileWriterFactory);
    }

    @Test
    void send() throws IOException {
        String outputPath = "path/to/out/file";
        String content = "CONTENT TO WRITE";

        when(args.getRequired(OUTPUT_PATH_KEY))
                .thenReturn(outputPath);
        when(fileWriterFactory.getFor(outputPath))
                .thenReturn(fileWriter);

        sender.send(content, args);

        verify(fileWriter).write(content);
    }

    @Test
    void send_should_throw_FileWriterContentSenderException() throws IOException {
        String outputPath = "path/to/out/file";
        String content = "CONTENT TO WRITE";

        when(args.getRequired(OUTPUT_PATH_KEY))
                .thenReturn(outputPath);
        when(fileWriterFactory.getFor(outputPath))
                .thenThrow(IOException.class);

        assertThrows(FileWriterContentSenderException.class,
                () -> sender.send(content, args));
    }
}
