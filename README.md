# ReactNative Foreground/Background Event Notifier

ReactNative plugin to detect when app(not ReactNative container) goes to background or foreground.

## Installation

```sh
yarn add @quan2nd/react-native-activity-state
```

## Usage - ONLY WORKING ON ANDROID
I have no experience working with IOS, I hope to get some support from the community
```js
import { onMoveToForeground, onMoveToBackground } from '@quan2nd/react-native-activity-state';

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
