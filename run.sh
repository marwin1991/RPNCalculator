#!/usr/bin/env bash
docker-compose rm -f rpn_calculator
docker-compose build
docker-compose up