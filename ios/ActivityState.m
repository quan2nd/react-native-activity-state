#import "ActivityState.h"

@implementation ActivityState
{
  bool hasListeners;
}
// Will be called when this module's first listener is added.
-(void)startObserving {
    hasListeners = YES;
    // Set up any upstream listeners or background tasks as necessary
}

// Will be called when this module's last listener is removed, or on dealloc.
-(void)stopObserving {
    hasListeners = NO;
    // Remove upstream listeners, stop unnecessary background tasks
}

RCT_EXPORT_MODULE()

// Example method
// See // https://reactnative.dev/docs/native-modules-ios
RCT_REMAP_METHOD(multiply,
                 multiplyWithA:(nonnull NSNumber*)a withB:(nonnull NSNumber*)b
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)
{
  NSNumber *result = @([a floatValue] * [b floatValue]);

  resolve(result);
}
- (NSArray<NSString *> *)supportedEvents {
  return @[@"onMoveToForeground"];
}
- (void)applicationDidBecomeActiveNotification:(NSNotification *)notification {
  NSLog(@"onMoveToForeground");
  if (hasListeners) { // Only send events if anyone is listening
    [self sendEventWithName:@"onMoveToForeground" body:@"name"];
  }
}
@end
