FROM node:latest

MAINTAINER Mayank Kastwar

ENV NODE_ENV=development
ENV PORT=8080

COPY . /var/www
WORKDIR /var/www

RUN npm install


EXPOSE $PORT

ENTRYPOINT [ "npm", "start"]