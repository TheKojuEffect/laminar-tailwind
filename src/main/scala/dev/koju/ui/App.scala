package dev.koju.ui

import com.raquo.laminar.api.L.{*, given}

def App(): Element =
  div(
    h1("Hello Laminar!"),
    CounterButton(),
  )
