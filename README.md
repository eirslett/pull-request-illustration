# Do not use

This is just an example project meant to illustrate a Hystrix PR.
The code is not actually tested.

The purpose of this code would be to support Zipkin tracing across
calls that are wrapped in Hystrix commands.

See:
src/main/resources/hystrix-plugins.properties
src/main/scala/com/github/eirslett/hystrix/zipkin/ZipkinTracingConcurrencyStrategy
