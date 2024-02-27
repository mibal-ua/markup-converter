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

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.application.port.InputProvider;

import java.io.IOException;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.nio.file.Path.of;
import static java.util.stream.Collectors.joining;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class FileInputProvider implements InputProvider {
    private static final String INPUT_PATH_KEY = "input-path";

    @Override
    public String getInput(Arguments args) {
        String path = args.getRequired(INPUT_PATH_KEY);
        return getAllLinesBy(path);
    }

    private String getAllLinesBy(String path) {
        try (Stream<String> lines = lines(of(path))) {
            return lines.collect(joining("\n"));
        } catch (IOException e) {
            throw new FileInputProviderException(
                    "Exception while reading all lines from file " +
                    path, e
            );
        }
    }
}
