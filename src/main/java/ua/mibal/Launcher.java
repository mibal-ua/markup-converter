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

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mibal.adapter.out.component.ArgumentParser;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.application.Application;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class Launcher {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ArgumentParser argumentParser = context.getBean(ArgumentParser.class);
        Arguments arguments = argumentParser.parse(args);

        Application application = context.getBean(Application.class);
        application.start(arguments);
    }
}
