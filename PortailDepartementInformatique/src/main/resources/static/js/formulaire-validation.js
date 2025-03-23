$(document).ready(function() {
    $.validator.addMethod("patternString", function (value, element) {
        return this.optional(element) || /^[A-Za-z -]+$/.test(value);
    }, "Seuls les caractères de A à Z, l'espace et le trait d'union sont permis");

    $.validator.addMethod("motDePasseFort", function(value, element) {
        return this.optional(element) || /^(?=.*[A-Z])(?=.*\d).{8,}$/.test(value);
    }, "Le mot de passe doit comporter au moins 8 caractères, dont au moins 1 lettre majuscule et 1 chiffre");

    $('#formulaire').validate({
        errorPlacement: function(error, element) {
            error.addClass("error");
            error.insertAfter(element);
        },
        rules: {
            prenom: {
                required: true,
                patternString: true
            },
            nom: {
                required: true,
                patternString: true
            },
            email: {
                required: true,
                email: true
            },
            motDePasse: {
                required: true,
                minlength: 8,
                motDePasseFort: true
            },
            confirmerMotDePasse: {
                required: true,
                minlength: 8,
                equalTo: "#motDePasse"
            },
            nomProjet: {
                required: true
            },
            description: {
                required: true
            }
        },
        messages: {
            prenom: {
                required: "Entrez votre prénom",
            },
            nom: {
                required: "Entrez votre nom"
            },
            email: {
                required: "Entrez votre adresse courriel",
                email: "Entrez une adresse courriel valide"
            },
            motDePasse: {
                required: "Entrez votre mot de passe",
                minlength: "Le mot de passe doit avoir 8 caractères minimum",
                motDePasseFort: "Le mot de passe doit comporter au moins 8 caractères, dont au moins 1 lettre majuscule et 1 chiffre"
            },
            confirmerMotDePasse: {
                required: "Confirmez votre mot de passe",
                minlength: "Le mot de passe doit avoir 8 caractères minimum",
                equalTo: "Les mots ne passe ne correspondent pas"
            },
            nomProjet: {
                required: "Entrez le nom du projet"
            },
            description: {
                required: "Entrez une description du projet"
            }
        },
        submitHandler: function(form) {
            // Form submission logic
            form.submit();
        }
    });
});