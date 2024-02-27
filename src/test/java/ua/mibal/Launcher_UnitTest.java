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

package ua.mibal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mibal.adapter.out.component.ArgumentParser;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.application.Application;
import ua.mibal.test.annotation.UnitTest;

import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class Launcher_UnitTest {

    @Mock
    private ArgumentParser argumentParser;
    @Mock
    private Arguments arguments;
    @Mock
    private Application application;

    private MockedConstruction<AnnotationConfigApplicationContext> mockedAppContextConstruction;

    @BeforeEach
    void setup() {
        mockedAppContextConstruction = mockConstruction(AnnotationConfigApplicationContext.class, (appContext, context) -> {
            when(appContext.getBean(ArgumentParser.class))
                    .thenReturn(argumentParser);
            when(appContext.getBean(Application.class))
                    .thenReturn(application);
        });
    }

    @AfterEach
    void teardown() {
        mockedAppContextConstruction.close();
    }

    @Test
    void main() {
        String[] args = {};

        when(argumentParser.parse(args))
                .thenReturn(arguments);

        Launcher.main(args);

        verify(application, times(1))
                .start(arguments);
    }
}
