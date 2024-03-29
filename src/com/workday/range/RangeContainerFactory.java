package com.workday.range;

import java.util.List;

import com.workday.range.impl.Node;
import com.workday.range.impl.RangeQuery;


/**

*

*/

public interface RangeContainerFactory {

/**

* builds an immutable container optimized for range queries.

* Data is expected to be 32k items or less.

* The position in the “data” array represents the “id” for that instance

* in question. For the “PayrollResult” example before, the “id” might be

* the worker’s employee number, the data value is the corresponding

* net pay. E.g, data[5]=2000 means that employee #6 has net pay of 2000.

*/

RangeQuery createContainer(long[]  data);

}

