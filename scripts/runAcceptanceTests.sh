#!/bin/bash

set -o errexit
set -o errtrace
set -o nounset
set -o pipefail

ROOT=`pwd`

function clean() {
    rm -rf ~/.m2/repository/com/example/
    rm -rf ~/.m2/repository/com/pillopl/
}

export SPRING_CLOUD_VERSION="${SPRING_CLOUD_VERSION:-Finchley.BUILD-SNAPSHOT}"
export SPRING_CLOUD_CONTRACT_VERSION="${SPRING_CLOUD_CONTRACT_VERSION:-2.0.1.BUILD-SNAPSHOT}"

clean

echo "Building the project for train [${SPRING_CLOUD_VERSION}] and contract [${SPRING_CLOUD_CONTRACT_VERSION}]"
./mvnw clean install -U -Dspring-cloud.version="${SPRING_CLOUD_VERSION}" -Dspring-cloud-contract.version="${SPRING_CLOUD_CONTRACT_VERSION}"
