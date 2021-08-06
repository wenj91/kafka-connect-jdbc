/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.connect.jdbc.util;

import java.util.HashMap;
import java.util.Map;

public class QueryMapUtil {
  /**
   * 将url参数转换成map
   *
   * @param param aa=11&bb=22&cc=33
   * @return map
   */
  public static Map<String, String> getQueryParams(String param) {
    Map<String, String> map = new HashMap<>();
    if (StringUtil.isBlank(param)) {
      return map;
    }

    String[] params = param.split("&");
    for (String s : params) {
      String[] p = s.split("=");
      if (p.length == 2) {
        map.put(p[0], p[1]);
      }
    }

    return map;
  }

  /**
   * 将map转换成url
   *
   * @param map map
   * @return string
   */
  public static String getQueryParamsByMap(Map<String, String> map) {
    if (map == null) {
      return "";
    }

    StringBuffer sb = new StringBuffer();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (sb.length() > 0) {
        sb.append("&");
      }

      sb.append(entry.getKey())
          .append("=")
          .append(entry.getValue());
    }

    return sb.toString();
  }

}
