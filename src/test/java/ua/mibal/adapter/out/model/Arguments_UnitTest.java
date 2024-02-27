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

package ua.mibal.adapter.out.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.mibal.test.annotation.UnitTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class Arguments_UnitTest {

    private Arguments args;

    @BeforeEach
    void setUp() {
        args = new Arguments();
    }

    @Test
    void get_and_put() {
        String key = "KEY";
        String value = "VALUE";
        args.put(key, value);

        String actual = args.get(key);

        assertEquals(value, actual);
    }

    @Test
    void getRequired() {
        String key = "KEY";
        String value = "VALUE";
        args.put(key, value);

        String actual = assertDoesNotThrow(
                () -> args.getRequired(key)
        );

        assertEquals(value, actual);
    }

    @Test
    void getRequired_should_throw_ArgumentRequiredException() {
        assertThrows(ArgumentRequiredException.class,
                () -> args.getRequired("Absent but required key"));
    }
}
