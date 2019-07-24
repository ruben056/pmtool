
Remarks:

            /**
             * lesson 15:
             * This whole thing doesn't make any sense:
             * - we assume there will only have this exception...
             * - the problem being a not so clear errmsg, is subjective
             * - the solution contains objective flaws
             * - also very heavyweight, with the projectIdentifierExceptionResponse...
             * really don't see the use
             * - als exception is annotated as responseStatus BadRequest,
             * but we manually set the responseStatus in the controllerAdvice...
             */