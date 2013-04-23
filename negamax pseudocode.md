copyright @ 2013 Christian Petry

Pseudocode for negamax

	negamax(s, d)	// state, depth

		if d <= 0 or s is final
			return value of s

		M <- moves (s)
		vbest = -inf
		for (m : M)
			s' <- m(s)   // perhaps game here is already over
			v<- -negamax(s' , d-1)
			if v > vbest
 	 			vbest <- v
		return vbest