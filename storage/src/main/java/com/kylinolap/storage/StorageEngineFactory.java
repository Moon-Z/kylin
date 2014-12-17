/*
 * Copyright 2013-2014 eBay Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kylinolap.storage;

import com.kylinolap.cube.CubeInstance;
import com.kylinolap.invertedindex.IIInstance;
import com.kylinolap.metadata.realization.DataModelRealizationType;
import com.kylinolap.metadata.realization.IDataModelRealization;
import com.kylinolap.storage.hbase.HBaseStorageEngine;
import com.kylinolap.storage.hbase.InvertedIndexStorageEngine;

/**
 * @author xjiang
 */
public class StorageEngineFactory {

    public static IStorageEngine getStorageEngine(IDataModelRealization realization) {
        if (realization.getType() == DataModelRealizationType.INVERTED_INDEX) {
            return new InvertedIndexStorageEngine((IIInstance) realization);
        } else {
            return new HBaseStorageEngine((CubeInstance) realization);
        }
    }

}
