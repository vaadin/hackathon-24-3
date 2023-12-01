# V24.3 Hackathon by Herberts
Repository for the 24.3 hackathon worked on by Herberts


# Worked on
* Using the new Started as a base. Ran into missing security issue.
* Rerouting to custom page after access-denied. Ran into setup issues.
* Tested expanding multi-select field in a fixed size horizontal layout, 
surrounded other components that change visibility. Found strange behaviour. 
* Tested multi-select with items on top. Wondered whether the grouped items should be sorted.

# Issues created
* Starter should offer export with Security enabled. [Issue](https://github.com/vaadin/start/issues/2915)
* Missing documentation for new rerouteToError in annotation. [Issue](https://github.com/vaadin/docs/issues/3013)
* Strange behaviour with expanding multi-select reported. [Issue](https://github.com/vaadin/web-components/issues/6897)
* Started a [Slack discussion](https://vaadin.slack.com/archives/C066U9C34NS/p1701443840082389) about grouping of items on top. 

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).
