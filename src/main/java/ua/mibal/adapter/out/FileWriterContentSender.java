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

import ua.mibal.adapter.out.component.FileWriterFactory;
import ua.mibal.application.port.ContentSender;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class FileWriterContentSender implements ContentSender {
    private final String filePath;

    public FileWriterContentSender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void send(String content) {
        try (Writer writer = FileWriterFactory.getFor(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            throw new FileWriterContentSenderException(String.format(
                    "Exception while trying to write into file '%s' next content '%s'",
                    filePath, content
            ), e);
        }
    }
}
