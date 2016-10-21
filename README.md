# FourmiLangton

On nomme fourmi de Langton un automate cellulaire bidimensionnel comportant un jeu de règles très simples.

Les cases d'une grille bidimensionnelle peuvent être blanches ou noires.
On considère arbitrairement l'une de ces cases comme étant l'emplacement initial de la fourmi. 
Dans l'état initial, toutes les cases sont de la même couleur.

La fourmi peut se déplacer à gauche, à droite, en haut ou en bas d'une case à chaque fois selon les règles suivantes :
- si la fourmi est sur une case noire, elle tourne de 90° vers la droite, change la couleur de la case en blanc et avance d'une case.
- Si la fourmi est sur une case blanche, elle tourne de 90° vers la gauche, change la couleur de la case en noir et avance d'une case.

Ces règles simples conduisent à un comportement étonnant de la fourmi : après une période initiale apparemment chaotique, 
la fourmi finit par construire une « route » formée par 104 étapes qui se répètent indéfiniment.
