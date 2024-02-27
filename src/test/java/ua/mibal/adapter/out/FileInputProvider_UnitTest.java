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
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.test.annotation.UnitTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class FileInputProvider_UnitTest {
    private static final String TEST_FILE_PATH = "test.txt";
    private static final String TEST_FILE_CONTENT = """
            YOU ARE AMAZING, MAAANN!!!!!
                        
            GOOD DAY, BRO :)""";

    private static final String INPUT_PATH_KEY = "input-path";

    private FileInputProvider provider;

    @Mock
    private Arguments arguments;

    private MockedStatic<Files> files;

    @BeforeEach
    void setup() {
        files = mockStatic(Files.class);
        provider = new FileInputProvider();
    }

    @AfterEach
    void teardown() {
        files.close();
    }

    @Test
    void getInput() {

        when(arguments.getRequired(INPUT_PATH_KEY))
                .thenReturn(TEST_FILE_PATH);
        files.when(() -> Files.lines(Path.of(TEST_FILE_PATH)))
                .thenReturn(TEST_FILE_CONTENT.lines());

        String actual = provider.getInput(arguments);

        assertEquals(TEST_FILE_CONTENT, actual);
    }

    @Test
    void getInput_should_throw_() {
        when(arguments.getRequired(INPUT_PATH_KEY))
                .thenReturn(TEST_FILE_PATH);
        files.when(() -> Files.lines(Path.of(TEST_FILE_PATH)))
                .thenThrow(IOException.class);

        assertThrows(FileInputProviderException.class,
                () -> provider.getInput(arguments));
    }
}
