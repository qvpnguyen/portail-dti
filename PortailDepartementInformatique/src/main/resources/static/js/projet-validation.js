$(document).ready(function() {
    $.validator.addMethod("patternString", function (value, element) {
        return this.optional(element) || /^[\p{L}0-9 \-]+$/u.test(value);
    }, "Seuls les caractères alphanumériques, l'espace et le trait d'union sont permis");

    $('#formulaire').validate({
        errorPlacement: function(error, element) {
            error.addClass("error");
            error.insertAfter(element);
        },
        rules: {
            nom: {
                required: true,
                patternString: true
            },
            description: {
                required: true
            },
            annee: {
                required: true
            }
        },
        messages: {
            nom: {
                required: "Entrez le nom du projet"
            },
            description: {
                required: "Entrez une description du projet"
            },
            annee: {
                required: "Choisissez une année"
            }
        },
        submitHandler: function(form) {
            // Form submission logic
            form.submit();
        }
    });
});