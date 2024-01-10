/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}"
  ],
  theme: {
    extend: {
      colors: {
        white: "#fff",
        limegreen: "#1ed760",
        whitesmoke: "#f9f9f9",
        black: "#000",
      },
      spacing: {},
      fontFamily: {
        inter: "Inter",
      },
      borderRadius: {
        mid: "17px",
      },
    },
    fontSize: {
      "11xl": "30px",
      "5xl": "24px",
      inherit: "inherit",
    },
  },
  corePlugins: {
    preflight: false,
  },
};

