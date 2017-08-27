import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class BaseServlet : HttpServlet() {
    private fun onService(request: HttpServletRequest?, response: HttpServletResponse?, service: (HttpServletRequest, HttpServletResponse) -> Unit, action: Action) {
        request!!
        response!!

        try {
            service.invoke(request, response)
        } catch (e: Exception) {
            onException(request, response, e, action)
        }
    }

    override final fun doHead(request: HttpServletRequest?, response: HttpServletResponse?) {
        try {
            onService(request, response, { req, resp -> onHead(req, resp) }, Action.HEAD)
        } catch (e: Exception) {
            onException(e, Action.HEAD)
        }
    }

    override final fun doGet(request: HttpServletRequest?, response: HttpServletResponse?) {
        try {
            onService(request, response, { req, resp -> onGet(req, resp) }, Action.GET)
        } catch (e: Exception) {
            onException(e, Action.GET)
        }
    }

    override final fun doPost(request: HttpServletRequest?, response: HttpServletResponse?) {
        try {
            onService(request, response, { req, resp -> onPost(req, resp) }, Action.POST)
        } catch (e: Exception) {
            onException(e, Action.POST)
        }
    }

    override final fun doPut(request: HttpServletRequest?, response: HttpServletResponse?) {
        try {
            onService(request, response, { req, resp -> onPut(req, resp) }, Action.PUT)
        } catch (e: Exception) {
            onException(e, Action.PUT)
        }
    }

    override final fun doDelete(request: HttpServletRequest?, response: HttpServletResponse?) {
        try {
            onService(request, response, { req, resp -> onDelete(req, resp) }, Action.DELETE)
        } catch (e: Exception) {
            onException(e, Action.DELETE)
        }
    }

    override final fun doOptions(request: HttpServletRequest?, response: HttpServletResponse?) {
        try {
            onService(request, response, { req, resp -> onOptions(req, resp) }, Action.OPTIONS)
        } catch (e: Exception) {
            onException(e, Action.OPTIONS)
        }
    }

    override final fun doTrace(request: HttpServletRequest?, response: HttpServletResponse?) {
        try {
            onService(request, response, { req, resp -> onTrace(req, resp) }, Action.TRACE)
        } catch (e: Exception) {
            onException(e, Action.TRACE)
        }
    }

    protected open fun onHead(request: HttpServletRequest, response: HttpServletResponse) {
        super.doHead(request, response)
    }

    protected open fun onGet(request: HttpServletRequest, response: HttpServletResponse) {
        super.doGet(request, response)
    }

    protected open fun onPost(request: HttpServletRequest, response: HttpServletResponse) {
        super.doPost(request, response)
    }

    protected open fun onPut(request: HttpServletRequest, response: HttpServletResponse) {
        super.doPut(request, response)
    }

    protected open fun onDelete(request: HttpServletRequest, response: HttpServletResponse) {
        super.doDelete(request, response)
    }

    protected open fun onOptions(request: HttpServletRequest, response: HttpServletResponse) {
        super.doOptions(request, response)
    }

    protected open fun onTrace(request: HttpServletRequest, response: HttpServletResponse) {
        super.doTrace(request, response)
    }

    protected open fun onException(e: Exception, action: Action) {
        e.printStackTrace()
    }

    protected open fun onException(request: HttpServletRequest, response: HttpServletResponse, e: Exception, action: Action) {
        e.printStackTrace()
    }

    protected enum class Action {
        HEAD,
        GET,
        POST,
        PUT,
        DELETE,
        OPTIONS,
        TRACE
    }
}
