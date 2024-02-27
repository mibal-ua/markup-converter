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
import ua.mibal.adapter.out.component.ArgumentParser;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.test.annotation.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static ua.mibal.test.util.ClasspathUtils.getPathToResourceInClasspath;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class FileInputProvider_UnitTest {
    private static final String TEST_FILE_PATH = getPathToResourceInClasspath("test.txt");
    private static final String TEST_FILE_CONTENT = """
            YOU ARE AMAZING, MAAANN!!!!!
                        
            GOOD DAY, BRO :)""";

    private static final String INPUT_PATH_ARG_KEY = "input-path";

    private FileInputProvider provider;

    @Mock
    private ArgumentParser argumentParser;

    @Mock
    private Arguments arguments;

    @BeforeEach
    void setUp() {
        provider = new FileInputProvider(argumentParser);
    }

    @Test
    void getInput() {
        String[] args = {};

        when(argumentParser.parse(args))
                .thenReturn(arguments);
        when(arguments.get(INPUT_PATH_ARG_KEY))
                .thenReturn(TEST_FILE_PATH);

        String actual = provider.getInput(args);

        assertEquals(TEST_FILE_CONTENT, actual);
    }
}
