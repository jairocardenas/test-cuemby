FROM maven:3.6.3-openjdk-16-slim

COPY entrypoint.sh /usr/local/bin/entrypoint.sh
RUN apt-get update && apt-get install dos2unix && dos2unix /usr/local/bin/entrypoint.sh && chmod +x /usr/local/bin/entrypoint.sh

#Start application
WORKDIR /usr/src/application
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["bash"]