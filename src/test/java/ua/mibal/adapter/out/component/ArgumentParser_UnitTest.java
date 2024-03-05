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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.test.annotation.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class ArgumentParser_UnitTest {

    private ArgumentParser parser;

    @BeforeEach
    void setUp() {
        parser = new ArgumentParser();
    }

    @Test
    void parse() {
        String[] args = {"-key", "val"};

        Arguments arguments = parser.parse(args);

        assertEquals("val", arguments.get("key"));
    }

    @Test
    void parse_should_throw_ArgumentParserException_if_args_length_is_not_even() {
        String[] args = {"first"};

        assertThrows(ArgumentParserException.class,
                () -> parser.parse(args));
    }

    @Test
    void parse_should_throw_ArgumentParserException_if_args_format_is_invalid() {
        String[] args = {"key_without_prefix", "val"};

        assertThrows(ArgumentParserException.class,
                () -> parser.parse(args));
    }
}
