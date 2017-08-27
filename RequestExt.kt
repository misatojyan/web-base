import javax.servlet.http.HttpServletRequest

fun HttpServletRequest.getByte(key: String) = getParameter(key).toByte()
fun HttpServletRequest.getShort(key: String) = getParameter(key).toShort()
fun HttpServletRequest.getInt(key: String) = getParameter(key).toInt()
fun HttpServletRequest.getLong(key: String) = getParameter(key).toLong()
fun HttpServletRequest.getFloat(key: String) = getParameter(key).toFloat()
fun HttpServletRequest.getDouble(key: String) = getParameter(key).toDouble()
fun HttpServletRequest.getBoolean(key: String) = getParameter(key).toBoolean()
fun HttpServletRequest.getString(key: String) = getParameter(key)

fun HttpServletRequest.getByteList(key: String) = getParameterValues(key).map { it.toByte() }
fun HttpServletRequest.getShortList(key: String) = getParameterValues(key).map { it.toShort() }
fun HttpServletRequest.getIntList(key: String) = getParameterValues(key).map { it.toInt() }
fun HttpServletRequest.getLongList(key: String) = getParameterValues(key).map { it.toLong() }
fun HttpServletRequest.getFloatList(key: String) = getParameterValues(key).map { it.toFloat() }
fun HttpServletRequest.getDoubleList(key: String) = getParameterValues(key).map { it.toDouble() }
fun HttpServletRequest.getBooleanList(key: String) = getParameterValues(key).map { it.toBoolean() }
fun HttpServletRequest.getStringList(key: String) = getParameterValues(key).map { it }
