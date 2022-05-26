# react-native-activity-state

pending

## Installation

```sh
npm install react-native-activity-state
```

## Usage - ONLY WORKING ON ANDROID

```js
import { onMoveToForeground, onMoveToBackground } from 'react-native-activity-state';

// ...

React.useEffect(() => {
    const subscriptionFore = onMoveToForeground(() => {
      console.log('onMoveToForeground');

    })
    const subscriptionBack = onMoveToBackground(() => {
      console.log('onMoveToBackground');

    })
    return () => {
      subscriptionFore.remove();
      subscriptionBack.remove();
    }
  }, []);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
