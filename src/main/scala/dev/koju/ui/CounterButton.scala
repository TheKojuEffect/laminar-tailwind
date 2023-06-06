package dev.koju.ui

import com.raquo.laminar.api.L.{*, given}

def CounterButton(): Element =
  val counter = Var(0)
  button(
    cls := "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded",
    tpe := "button",
    "Count is ",
    child.text <-- counter,
    onClick --> { _ => counter.update(c => c + 1) },
  )
end CounterButton
