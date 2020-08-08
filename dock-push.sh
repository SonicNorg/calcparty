#!/bin/bash
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker tag party $DOCKER_USERNAME/party:$TRAVIS_BRANCH && docker push $DOCKER_USERNAME/party:$TRAVIS_BRANCH