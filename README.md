# hackathon-24-3
Repository for the 24.3 hackathon

# description
Thre branch contains a utility class and some samples: The util will automate the i18n process in the following ways:
- for the current view (routed class), it scans the fields. Every HasLabel/HasText field is applied with its matching translation based on the class and field name e.g. MainView#someComponent will be parsed to "mainView.someComponent" (a bit like the binder with its bindInstanceFields).
- for the current ui, it scans the dom / component tree. Every component (with label or text capacity), having a definied i18n key (defined using the util), will be translated. Also here a translation path is build automatically, based on the current routed class and any parent components with an own i18n key, e.g. "mainView.form.address.street". For this path building all parent components are taking into account, e.g. forms or vertical layouts.
- Page title can also be set this way
- Global customizable date picker i18n, e.g. "datePicker.monthNames". Will be applied on any date (time) picker in the component tree.
- No need to manually implement HasLocaleChange. This is done once in the service init listener using the util. The util will then take care of applying the correct translations on navigation time (unfortunately I was not able to do it for components, that are attached manually later)

## rules
Hackathon Rules

1. Versions: Use Platform `24.3.0.beta1` and/or Hilla `2.4.0`
2. Choose your project: You can work on an app, fixes, migrations, new features, docs, addons, DS, or just reporting issues.
3. Deadline: Upload your work to the [GitHub Repository](https://github.com/vaadin/hackathon-24-3) by Monday, the 4th at noon.
4. Contribution options: If you don’t have any code to show, please add a README or screenshots demoing your work.
5. Rewards: Everyone gets a gift, and there are prizes for the top three winners.
6. Communication: Use Slack channel #hackathon-24-3 for discussions.
7. Documentation: Refer to vaadin.com/docs/latest for help and information.
