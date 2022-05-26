import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { onMoveToForeground, onMoveToBackground } from 'react-native-activity-state';

export default function App() {

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

  return (
    <View style={styles.container}>
      <Text>Activity State</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
