package com.scalding.examples

import com.twitter.scalding._

/**
  * Created by iSingh on 9/3/17.
  */

class WordCountJob(args: Args) extends Job(args) {
  TextLine(args("input"))
    .flatMap('line -> 'word) { line: String ⇒
      line.split("""\s+""") }
    .groupBy('word) { _.size }
    .write(Tsv(args("output")))
}
