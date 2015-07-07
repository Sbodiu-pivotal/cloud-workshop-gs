cf cups config-service -p '{"uri":"http://config-server.apj.fe.pivotal.io/"}'
cf cups service-registry -p '{"uri":"http://eureka.apj.fe.pivotal.io/"}'
