# Services for barborak.com Using Google App Engine

## Get Started

https://cloud.google.com/appengine/

I created my `barborak-website` project there.

## Setup Eclipse

https://cloud.google.com/eclipse/docs/quickstart

## Develop

Checkout this project and my program-ab fork.

The one service I have is for [Sassubot](https://barborak.com/sassubot/). 

Because I am hosting the service at appspot.com but calling it from barborak.com, I needed to add a CORS response filter.

To debug, do `Debug As.. > App Engine` and then open the URL show in the console.

If static files are changed, you may have to publish them. Open the `Servers` view, right-click the app engine server and choose `Publish`.

## Deploy

https://cloud.google.com/eclipse/docs/deploying

After setting things up, do `Deploy to App Engine Standard...`.
