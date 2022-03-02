# Scramble Challenge

generated using Luminus version "4.33"

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein run 

## Scrable 
```
(defn scramble [str1 str2]
  (set/subset? (set str2) (set str1)))
```

## License

Copyright © 2022
