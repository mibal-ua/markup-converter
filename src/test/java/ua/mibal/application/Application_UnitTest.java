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

package ua.mibal.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ua.mibal.application.port.ContentSender;
import ua.mibal.application.port.Converter;
import ua.mibal.application.port.InputProvider;
import ua.mibal.test.annotation.UnitTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class Application_UnitTest {

    private Application app;

    @Mock
    private InputProvider inputProvider;
    @Mock
    private Converter converter;
    @Mock
    private ContentSender contentSender;

    @BeforeEach
    void setUp() {
        app = new Application(inputProvider, converter, contentSender);
    }

    @Test
    void start() {
        String[] args = {};
        String input = "SOURCE";
        String output = "RESULT";

        when(inputProvider.getInput(args))
                .thenReturn(input);
        when(converter.convert(input))
                .thenReturn(output);

        app.start(args);

        verify(contentSender, times(1))
                .send(output, args);
    }
}
