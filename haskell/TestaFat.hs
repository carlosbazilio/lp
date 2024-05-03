module TestaFat
( testaFat
) where

import TesteAutomatizado

casos = [(0,1), (5,120)]

testaFat f = testaFuncao f casos
