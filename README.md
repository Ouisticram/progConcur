# progConcur
Développer un serveur TCP pour le protocole echo
(https://tools.ietf.org/html/rfc862), capable de supporter
plusieurs connexions simultanées. 

Si un client reste inactif pendant une durée supérieure à un paramètre fixée, cette connexion est fermée par le
serveur.

Deux implémentations sont à fournir : l’une utilisant l’API de bas
niveau, l’autre utilisant l’API de haut niveau. 

Au démarrage, le serveur lira un fichier de configuration pour déterminer les valeurs des paramètres
suivants : 
implémentation à utiliser, 
nombre maximal de connexions
simultanées, d
urée maximale d’inactivité d’une connexion, 
port d’écoute du serveur.