#! /bin/bash
echo " ARGS:  $@"
/usr/bin/geckodriver --log fatal "$@" > /dev/null 2>&1