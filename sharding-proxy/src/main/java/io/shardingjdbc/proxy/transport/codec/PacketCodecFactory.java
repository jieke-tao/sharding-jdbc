/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingjdbc.proxy.transport.codec;

import io.shardingjdbc.core.constant.DatabaseType;
import io.shardingjdbc.proxy.transport.codec.mysql.MySQLPacketCodec;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Database protocol packet codec factory.
 *
 * @author zhangliang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PacketCodecFactory {
    
    /**
     * Create packet codec instance.
     * 
     * @param databaseType database type
     * @return packet codec instance
     */
    public static PacketCodec createPacketCodecInstance(final DatabaseType databaseType) {
        switch (databaseType) {
            case MySQL:
                return new MySQLPacketCodec();
            default:
                throw new UnsupportedOperationException(String.format("Cannot support database type '%s'", databaseType));
        }
    }
}