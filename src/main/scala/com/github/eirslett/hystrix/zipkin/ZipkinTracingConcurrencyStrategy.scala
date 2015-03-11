package com.github.eirslett.hystrix.zipkin

import java.util.concurrent.Callable

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy
import com.twitter.finagle.tracing.Trace

final class ZipkinTracingConcurrencyStrategy extends HystrixConcurrencyStrategy {
  override def wrapCallable[T](callable: Callable[T]) = {
    // store the id
    val id = Trace.id
    super.wrapCallable(new Callable[T] {
      override def call(): T = {
        // reload the id on the new thread
        Trace.letId(id) {
          callable.call()
        }
      }
    })
  }
}
