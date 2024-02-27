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

package ua.mibal.adapter.out.component;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.Arguments;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class ArgumentParser {
    private static final String KEY_PREFIX = "--";

    public Arguments parse(String[] args) {
        validate(args);

        Arguments arguments = new Arguments();
        for (int i = 0; i < args.length; i += 2) {
            String key = getKeyName(args[i]);
            String value = args[i + 1];
            arguments.put(key, value);
        }
        return arguments;
    }

    private void validate(String[] args) {
        if (args.length % 2 != 0) {
            throw new ArgumentParserException(
                    "Arguments length must be even number. " +
                    "Actual is " + args.length
            );
        }
    }

    private String getKeyName(String arg) {
        if (!arg.startsWith(KEY_PREFIX)) {
            throw new ArgumentParserException(String.format(
                    "Key '%s' must starts with '%s'",
                    arg, KEY_PREFIX
            ));
        }
        return arg.substring(KEY_PREFIX.length());
    }
}
