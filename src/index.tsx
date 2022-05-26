import { NativeModules, Platform, DeviceEventEmitter } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-activity-state' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const ActivityState = NativeModules.ActivityState
  ? NativeModules.ActivityState
  : new Proxy(
    {},
    {
      get() {
        throw new Error(LINKING_ERROR);
      },
    }
  );

export function onMoveToForeground(callback: (data: string) => void) {
  ActivityState;
  return DeviceEventEmitter.addListener('onMoveToForeground', callback);
}

export function onMoveToBackground(callback: (data: string) => void) {
  ActivityState;
  return DeviceEventEmitter.addListener('onMoveToBackground', callback);
}
// export function multiply(a: number, b: number): Promise<number> {
//   return ActivityState.multiply(a, b);
// }