subseq _ [] = True
subseq [] _ = False
subseq seq sub = subseqaux seq sub seq sub

subseqaux seqorig suborig _ [] = True
subseqaux seqorig suborig [] _ = False

subseqaux seqorig suborig (pseq:seq) (psub:sub)
	| pseq == psub = subseqaux seqorig suborig seq sub
	| otherwise = subseqaux (tail seqorig) suborig (tail seqorig) suborig

main = print (subseq [1, 2, 1, 2, 3, 1] [1, 2, 3])

