<%@ page language="java" session="false" contentType="application/raml+yaml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>#%RAML 0.8

title: CCG REST API
baseUri: ${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, '')}${pageContext.request.contextPath}<c:url value="/api" />
mediaType: application/json
schemas:
    - Leaderboard: !include Leaderboard.json
    - User: !include User.json
/leaderboard:
    get:
        queryParameters:
            offset:
                type: integer
                minimum: 0
                default: 0
                example: 0
                description: Offset into the leaderboard for the results
            count:
                type: integer
                minimum: 0
                default: 10
                example: 10
                description: Number of results to return
        responses:
            200:
                body:
                    application/json:
                        schema: Leaderboard
/users:
    post:
        description: Create a new User
        body:
            application/json:
                schema: User
        responses:
            201:
                description: The user was successfully created
                body:
                    application/json:
                        schema: User
            400:
                description: The user details were not valid
            409:
                description: The user to be created was a duplicate in some way
    /me:
        get:
            description: Get the user details of the currently authenticated user
            responses:
                200:
                    description: Successfully return the details of the user
                    body:
                        application/json:
                            schema: User
                401:
                    description: The request has not been authenticated
    /{userId}:
        get:
            description: Get the user details of the requested user
            responses:
                200:
                    description: Successfully return the details of the user
                    body:
                        application/json:
                            schema: User
                404:
                    description: The requested user does not exist
                401:
                    description: The request has not been authenticated
                403:
                    description: The request has been authenticated but is not allowed to see the details of this user
        put:
            description: Update the user details of the requested user
            body:
                application/json:
                    schema: User
            responses:
                200:
                    description: The user was successfully updated
                    body:
                        application/json:
                            schema: User
                400:
                    description: The user details were not valid
                409:
                    description: The request was for an old version of the user
        delete:
            description: Delete the user details of the requested user
            responses:
                204:
                    description: The user was successfully deleted
                409:
                    description: The request was for an old version of the user
