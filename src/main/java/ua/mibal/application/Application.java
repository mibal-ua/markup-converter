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

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.application.port.ContentSender;
import ua.mibal.application.port.Converter;
import ua.mibal.application.port.InputProvider;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class Application {
    private final InputProvider inputProvider;
    private final Converter converter;
    private final ContentSender contentSender;

    public Application(InputProvider inputProvider,
                       Converter converter,
                       ContentSender contentSender) {
        this.inputProvider = inputProvider;
        this.converter = converter;
        this.contentSender = contentSender;
    }

    public void start(Arguments args) {
        String input = inputProvider.getInput(args);
        String output = converter.convert(input);
        contentSender.send(output, args);
    }
}
