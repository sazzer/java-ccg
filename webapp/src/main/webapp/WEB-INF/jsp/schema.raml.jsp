<%@ page language="java" session="false" contentType="application/raml+yaml; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>#%RAML 0.8

title: CCG REST API
baseUri: ${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, '')}${pageContext.request.contextPath}<c:url value="/api" />
mediaType: application/json
schemas:
  - Leaderboard: !include Leaderboard.json
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
